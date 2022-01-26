(ns jb.components.search-form
  (:require [jb.db :refer [db ui-state]]
            [jb.config :refer [BACKEND-URL]]
            [jb.search :as search]
            [ajax.core :refer [GET]]))

(defn handle-search [ev]
  (.preventDefault ev)
  (swap! ui-state assoc :search-in-progress true)
  (search/send-request))

(defn search []
  [:div.search
   [:form.search__form
    {:action    "/search"
     :on-submit handle-search}
    [:input.search__text
     {:type        "text"
      :auto-focus  true
      :disabled    (:search-in-progress @ui-state)
      :placeholder "Search..."
      :value       (:query @ui-state)
      :on-change   #(swap! ui-state assoc :query (.. % -target -value))}]
    [:button.search__btn.hidden {:type "submit"} "Find"]]])