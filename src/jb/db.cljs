(ns jb.db
  (:require [shadow.resource :as rc]
            [reagent.core :as r]))

;(def init-db (-> "resp.json"
;                 (rc/inline)
;                 (js/JSON.parse)
;                 (js->clj :keywordize-keys true)))

(def db (r/atom {}))

(def ui-state (r/atom {:query      ""
                       :query-page 0}))