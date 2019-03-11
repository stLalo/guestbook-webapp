(ns restapi-app.events
  (:require [re-frame.core :as rf]
            [restapi-app.db :refer [default-state]]
            ))



;;(def get-messages
;;(rf/->interceptor
;;  :id :get-messages
;;)
;;)

(rf/reg-event-db
  :init-app-state
  [get-messages]
  (fn [messages]
    (assoc db messages)
    )
)
