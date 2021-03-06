(ns jb.search
  (:require [jb.db :refer [ui-state db]]
            [ajax.core :refer [GET]]
            [jb.config :refer [BACKEND-URL]]))

(defn handle-resp [r]
  (reset! db r)
  (swap! ui-state assoc :search-in-progress false))


(defn send-request []
  (GET (str BACKEND-URL "/search")
       {:headers {"Accept" "application/transit+json" "Access-Control-Allow-Origin" "*"}
        :params  {:query      (:query @ui-state)
                  :query-page (:query-page @ui-state)}
        :handler handle-resp}))
