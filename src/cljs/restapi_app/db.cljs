(ns restapi-app.db
  (:require [re-frame.core :as rf]
            [clojure.spec.alpha :as s]
            [restapi-app.guestbook :refer [get-messages]]

            )
  )


(s/def ::id int?)
(s/def ::name string?)
(s/def ::comment string?)
(s/def ::timestamp inst?)


(s/def ::message (s/keys :req-un [::id ::name ::comment ::timestamp]))

;;Primarly load the messages in the board
(def default-db
  {}
)
