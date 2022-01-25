(ns jb.components.search
  (:require [jb.db :refer [db]]
            [reagent.core :as r]
            [jb.config :refer [BACKEND-URL]]
            [ajax.core :refer [GET POST]]))

(defonce query (r/atom ""))

(defn handle-search-resp [resp]
  (prn "Response received.")
  (reset! db resp))

(defn handle-search [ev]
  (.preventDefault ev)
  (GET (str BACKEND-URL "/search")
       {:headers {"Accept" "application/transit+json"}
        :params  {:query @query}
        :handler handle-search-resp}))

(defn search []
  [:div.search
   [:form.search__form {:action "/search" :on-submit handle-search}
    [:input.search__text {:type        "search"
                          :placeholder "Search..."
                          :value       @query
                          :on-change   #(reset! query (.. % -target -value))}]
    [:button.search__btn.hidden {:type "submit"} "Find"]]])