(ns ^:figwheel-no-load restapi-app.app
  (:require [restapi-app.core]
            [cljs.spec.alpha :as s]
            [expound.alpha :as expound]
            [devtools.core :as devtools]))

(set! s/*explain-out* expound/printer)

(enable-console-print!)


