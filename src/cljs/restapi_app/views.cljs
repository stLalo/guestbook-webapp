(ns restapi-app.views
    (:require [restapi-app.guestbook :as gb]))


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
          [:a.nav-link.active {:href "/"} "Home"]
        ]
        [:li.nav-item
          [:a.nav-link {:href "/guestbook"} "guestbook"]
        ]
        [:li.nav-item
          [:a.nav-link {:href "/katz"} "katz"]
        ]
        [:li.nav-item
          [:a.nav-link {:href "/dogz"} "dogz"]
        ]
        [:li.nav-item
          [:a.nav-link {:href "/about"} "about"]
        ]
      ]
    ]
   ]
  ]
)


(defn home-page []
    [navbar]
)