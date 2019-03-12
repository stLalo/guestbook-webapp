(ns restapi-app.events
  (:require [re-frame.core :as rf :refer [inject-cofx]]
            [restapi-app.guestbook :refer [get-messages]]
            [restapi-app.db :as db]
  ))


;; -- Event Handlers ----------------------------------------------------------
;;
(rf/reg-event-fx   ;; usage: (dispatch [:initialise-db])
 :initialise-db ;; sets up initial application state
 ;; the event handler (function) being registered
 (fn [{:keys [page]} _]                    ;; take 2 vals from coeffects. Ignore event vector itself.
            {:db (assoc db/default-db :active-page page)})) ;; what it returns becomes the new application state


(rf/reg-event-fx
:set-current-page
(fn [db [_ current-page]]
(assoc db :current-page current-page))
)