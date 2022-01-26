(ns jb.db
  (:require [shadow.resource :as rc]
            [reagent.core :as r]))

(def db (r/atom {}))

(def ui-state (r/atom {:query              ""
                       :search-in-progress false
                       :query-page         0}))