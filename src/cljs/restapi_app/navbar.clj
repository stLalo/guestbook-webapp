(ns restapi-app.navbar
  (:require [secretary.core :as secretary :refer-macros [defroute]])
)


(defn navbar []
  [:div.container
   [:nav.navbar
    [:a {:href "/"}]
    [:a {:href "/guestbook"}]
    [:a {:href "/katz"}]
    [:a {:href "/dogz"}]
    [:a {:href "/about"}]
    ]]
  )