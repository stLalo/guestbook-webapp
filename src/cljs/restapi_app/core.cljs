(ns restapi-app.core
  (:require [reagent.core :as reagent :refer [atom]]
            [restapi-app.websocket :as ws]
            [restapi-app.guestbook :as gb]
            [restapi-app.events]
            [restapi-app.db]
            [restapi-app.views]
            [goog.events :as events]
            [re-frame.core :as rf])
  (:import [goog History]
           [goog.history EventType]))


;;Inti the state of the application-db


(defn ^:export main
 []
  (rf/dispatch-sync [:initialise-db])
  (ws/make-websocket! (str "ws://" (.-host js/location) "/ws") gb/update-messages!)
  (rf/clear-subscription-cache!)
  (reagent/render-component [#'restapi-app.views/home-page] (.getElementById js/document "app"))
)
