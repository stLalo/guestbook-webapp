(ns restapi-app.routes.services
  (:require [ring.util.http-response :refer :all]
            [compojure.api.sweet :refer :all]
            [clj-http.client :as client]
            [clojure.java.io :as io]
            [clojure.data.xml :as xml]
            [schema.core :as s]))



(defn defineLinks [xmlObj]
  (let [links (atom nil)]
    (doseq [xmlIn (xml-seq xmlObj) :when (= :url (:tag xmlIn))]
      (swap! links conj (first (:content xmlIn)) )
      )
    @links
  )
)

(defn parse-xml [xmlObj]
  (->> xmlObj
       .getBytes
       io/input-stream
       xml/parse
       defineLinks)
  )

(defn get-links [link-count]
  (-> "http://thecatapi.com/api/images/get?format=xml&results_per_page="
      (str link-count)
      client/get
      :body
      parse-xml))

(def service-routes
  (api
    {:swagger {:ui "/swagger-ui"
               :spec "/swagger.json"
               :data {:info {:version "1.0.0"
                             :title "Sample API"
                             :description "Sample Services"}}}}
    
    (context "/api" []
      :tags ["thingie"]
      
      (GET "/kittie-pics" []
        :query-params [linkCount :- Long]
        :return [s/Str]
        :summary "Returns a Collections of kittiecat imgs"
        (ok (get-links linkCount)))
      
      (GET "/plus" []
        :return       Long
        :query-params [x :- Long, {y :- Long 1}]
        :summary      "x+y with query-parameters. y defaults to 1."
        (ok (+ x y)))

      (POST "/minus" []
        :return      Long
        :body-params [x :- Long, y :- Long]
        :summary     "x-y with body-parameters."
        (ok (- x y)))

      (GET "/times/:x/:y" []
        :return      Long
        :path-params [x :- Long, y :- Long]
        :summary     "x*y with path-parameters"
        (ok (* x y)))

      (POST "/divide" []
        :return      Double
        :form-params [x :- Long, y :- Long]
        :summary     "x/y with form-parameters"
        (ok (/ x y)))

      (GET "/power" []
        :return      Long
        :header-params [x :- Long, y :- Long]
        :summary     "x^y with header-parameters"
        (ok (long (Math/pow x y)))))))
