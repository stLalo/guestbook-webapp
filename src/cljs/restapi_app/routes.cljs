(ns restapi-app.routes
    (:require
        [secretary.core :as secretary]
        [re-frame.core :refer [dispatch dispatch-sync]]
    )
)


(secretary/defroute "/home" [] () (dispatch [:current-page ]))