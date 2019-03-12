(ns restapi-app.views
    (:require [restapi-app.guestbook :as gb]
              [restapi-app.katz  :refer [katz-page]]
              [restapi-app.dogz :refer [dogz-page]]
              [restapi-app.events]
              [bidi.bidi :as bd]
              [restapi-app.routes :refer [get-route]]
              [restapi-app.db]
              [re-frame.core :as rf :refer [dispatch dispatch-sync]]
    ))

(defn navbar []
  [:div.container
   [:nav.navbar.navbar-dark.navbar-expand.bg-dark
   [:button.navbar-toggler
          {:type "button"
           :data-toggle "collapse"
           :data-toggler "#collapsing-navbar"}]
    [:a.navbar-brand.text-white "guestbook"]
    [:div#collapsing-navbar.collapse.navbar-collapse.navLinks
      [:ul.nav.navbar-nav.mr-auto
        [:li.nav-item
          [:a.nav-link.active {:href "/home" :on-click (get-route "/home")} "Home"]
        ]
        [:li.nav-item
          [:a.nav-link {:href "/guestbook" :on-click (get-route "/guestbook")} "guestbook"]
        ]
        [:li.nav-item
          [:a.nav-link {:href "/katz" :on-click (get-route "/katz")}  "katz"]
        ]
        [:li.nav-item
          [:a.nav-link {:href "/dogz" :on-click (get-route "/dogz")} "dogz"]
        ]
        [:li.nav-item
          [:a.nav-link {:href "/about" :on-click (get-route "/about")} "about"]
        ]
      ]
    ]
   ]
  ]
)


(defn home-page []
    (fn []
      [navbar]
    )
)