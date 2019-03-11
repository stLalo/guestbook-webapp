(ns restapi-app.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [restapi-app.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[restapi-app started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[restapi-app has shut down successfully]=-"))
   :middleware wrap-dev})
