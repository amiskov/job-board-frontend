(ns jb.components.hits
  (:require [jb.components.job-card :refer [job-card]]))

(defn hits [found-jobs]
  [:div.job-list
   (for [j found-jobs]
     ^{:key (:last-modified-ts j)}
     [job-card j])])
