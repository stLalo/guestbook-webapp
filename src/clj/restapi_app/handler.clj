(ns restapi-app.handler
  (:require [restapi-app.middleware :as middleware]
            [restapi-app.layout :refer [error-page]]
            [restapi-app.routes.home :refer [home-routes]]
            [restapi-app.routes.services :refer [service-routes]]
            [compojure.core :refer [routes wrap-routes]]
            [ring.util.http-response :as response]
            [compojure.route :as route]
            [restapi-app.env :refer [defaults]]
            [mount.core :as mount]
            [restapi-app.routes.websocket :refer [websocket-routes]]))

(mount/defstate init-app
  :start ((or (:init defaults) identity))
  :stop  ((or (:stop defaults) identity)))

(mount/defstate app
  :start
  (middleware/wrap-base
    (routes
     websocket-routes
     (-> #'home-routes
         (wrap-routes middleware/wrap-csrf)
         (wrap-routes middleware/wrap-formats))
     #'service-routes
     (route/not-found
      (:body
       (error-page {:status 404
                    :title "page not found"}))))))

