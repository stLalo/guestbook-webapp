(ns restapi-app.guestbook
            (:require [ajax.core :refer [GET POST]]
            [restapi-app.websocket :as ws])
  )
(defonce messageList (atom []))

(defn get-messages []
  (GET "/messages"
    {:headers {"Accepts" "application/transit+json"}
     :handler #(reset! messageList (vec %))}))

(defn message-list []
  [:ul.content
   (for [{:keys [timestamp message name]} @messageList]
     ^{:key timestamp}
     [:li
      [:time (.toLocaleString timestamp)]
      [:p message]
      [:p " - " name]])])

(defn message-form []
  (let [fieldValue (atom nil)]
    (fn []
      [:div.container
       [:div.form-group
        [:p "Name:"
         [:input.form-control
          {:type :text
           :placeholder "Type in your name"
           :value (:name @fieldValue)
           :on-change #(swap! fieldValue assoc :name (-> % .-target .-value))}]]
        [:p "Message:"
         [:textarea.form-control
          {:rows 4
           :cols 50
           :value (:message @fieldValue)
           :on-change #(swap! fieldValue assoc :message (-> % .-target .-value))}]]
        [:input.btn.btn-primary
         {:type :submit
          :on-click #(ws/send-transit-message! @fieldValue)
          :value "comment"}]]])))

(defn guestbook []
  (get-messages)
[:div.container
 [:div.row
  [:div.col
   [:h2 "Welcome to the restapi-app"]]]
 [:div.row
  [:div.col
   [message-list]]]
 [:div.row
  [:div.col
   [message-form]]]])

(defn update-messages! [{:keys [name message timestamp]}]
  (get-messages))