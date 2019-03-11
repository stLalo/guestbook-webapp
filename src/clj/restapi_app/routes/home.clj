(ns restapi-app.routes.home
  (:require [restapi-app.layout :as layout]
            [restapi-app.db.core :as db]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :as response]
            
[ring.util.response :refer [response]]
            [clojure.java.io :as io]))

(defn home-page [request]
  (layout/render request "home.html"))

(defroutes home-routes
  (GET "/" request (home-page request))
  (GET "/messages" [] (response (db/get-messages)))
  (GET "/docs" []
    (-> (response/ok (-> "docs/docs.md" io/resource slurp))
        (response/header "Content-Type" "text/plain; charset=utf-8"))))

