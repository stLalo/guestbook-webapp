(ns restapi-app.events
  (:require [re-frame.core :as rf]
            [restapi-app.guestbook :refer [get-messages]]
            [restapi-app.db :refer [default-state]]
  ))



;;(def get-messages
;;(rf/->interceptor
;;  :id :get-messages
;;)
;;)

(rf/reg-event-db 
  :set-current-page
  (fn [db [_ new-page]]
    (assoc db :curr-page new-page)
  )
)

(rf/reg-event-db
  :init-app-state
  (fn [_ _]
    {:messages (get-messages)
     :curr-page "/"}
  )
)
