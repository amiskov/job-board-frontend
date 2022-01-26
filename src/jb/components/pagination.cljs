(ns jb.components.pagination
  (:require [jb.db :refer [db ui-state]]))

(defn handle-page-request [ev page]
  (.preventDefault ev)
  #(assoc ui-state :current-page page))

(defn pagination []
  [:ul.pagination
   (doall
     (for [p (range 1 (inc (:pages @db)))]
       ^{:key p}
       [:li.pagination__item
        [:a.pagination__link
         {:href     (str "/search?page=" p)
          :on-click #(handle-page-request % p)
          :class    (when (= p (inc (:current-page @db)))
                      "pagination__link_active")}
         p]]))])
