(ns restapi-app.doo-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [restapi-app.core-test]))

(doo-tests 'restapi-app.core-test)

