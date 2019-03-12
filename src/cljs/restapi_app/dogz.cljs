(ns restapi-app.dogz 
    (:require [reagent.core :as reagent :refer [atom]]
            [ajax.core :refer [GET POST]]
))


(defonce links (atom nil))

(defn get-dogz! []
    (GET "/dogz-pics"
        {
            :params {:picCount 10}
            :handler #(reset! links (vec %))
        }
    )
)


(defn make-dogz []
    [:ul
        (for [dog @links]
            ^{:key dog}
            [:li 
                [:img {:src dog}]]
        )
    ]
)



(defn dogz-page []
    (get-dogz!)
    [:div.container
        [:div.row
            [:div.col
                [make-dogz]
            ]
        ]
    ]
)