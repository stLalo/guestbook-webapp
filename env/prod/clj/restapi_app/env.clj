(ns restapi-app.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[restapi-app started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[restapi-app has shut down successfully]=-"))
   :middleware identity})
