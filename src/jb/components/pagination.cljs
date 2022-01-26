(ns jb.components.pagination
  (:require [jb.db :refer [db]]))

(defn pagination []
  [:ul.pagination
   (doall
     (for [p (range 1 (inc (:pages @db)))]
       ^{:key p}
       [:li.pagination__item
        [:a.pagination__link
         {:href  (str "?page=" p)
          :class (when (= p (inc (:current-page @db)))
                   "pagination__link_active")}
         p]]))])
