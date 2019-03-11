(ns restapi-app.core
  (:require [reagent.core :as reagent :refer [atom]]
            [restapi-app.websocket :as ws]
            [restapi-app.guestbook :as gb]
            [restapi-app.events]
            [restapi-app.views :refer [home-page]]
            [secretary.core :as secretary]
            [goog.events :as events]
            [re-frame.core :as rf]
            [ajax.core :refer [GET POST]])
  (:import [goog History]
           [goog.history EventType]))


;;Inti the state of the application-db
(rf/dispatch-sync [:init-app-state])


(defn main-app []
(fn []
  [home-page]
)
)


(defn mount-components []
  (reagent/render-component [#'main-app] (.getElementById js/document "app")))


(defn init! []
  (ws/make-websocket! (str "ws://" (.-host js/location) "/ws") gb/update-messages!)
  (mount-components))