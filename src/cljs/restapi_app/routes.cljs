(ns restapi-app.routes
    (:require
        [bidi.bidi :as bd]
        [re-frame.core :refer [dispatch dispatch-sync]]
        [restapi-app.guestbook :as gb]
        [restapi-app.events]
    )
)
(def guestbook-routes ["/" [
                            ["home.html" :home]
                            ["dogz" :dogz]
                            ["katz" :katz]
                            ["about" :about]    
                            [true :not-found]]])


(defn get-route [href]
    (dispatch [:set-current-page (bd/match-route guestbook-routes href)])
)