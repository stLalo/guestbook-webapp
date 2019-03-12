(ns restapi-app.routes
    (:require
        [bidi.bidi :as bd]
        [re-frame.core :refer [dispatch dispatch-sync]]
        [restapi-app.guestbook :as gb]
    )
)
(def guestbook-routes ["/" [
                            ["home.html" :home]
                            ["dogz" :dogz]
                            ["katz" :katz]
                            ["about" :about]    
                            [true :not-found]]])