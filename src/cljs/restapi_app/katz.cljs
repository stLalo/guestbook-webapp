(ns restapi-app.katz
  (:require [reagent.core :as reagent :refer [atom]]
            [ajax.core :refer [GET POST]]
            )
)



(defonce links (atom nil))


(defn get-katz! []
  (GET "/api/katz-pics"
    {
      :params {:picCount 5}
      :handler #(reset! links (vec  % ))
    }
  )
)

(defn make-katz []
 [:ul.content
   (for [link @links]
    ^{:key link}
     [:li
      [:img {:src (str  link )}]
      ]
    )
  ])


(defn katz-page []
    (get-katz!)
        [:div.container
            [:h2 "Katz!"]
            [make-katz]
        ]
        
)
