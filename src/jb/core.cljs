(ns jb.core
  (:require
    [reagent.dom :as rdom]
    ;; test data
    [jb.db :refer [db]]
    ;; components
    [jb.components.logo :refer [logo]]
    [jb.components.search :refer [search]]
    [jb.components.pagination :refer [pagination]]
    [jb.components.hits :refer [hits]]))

(defn app []
  [:main
   [:div.header
    [:div.container
      [logo]
      [search]]]
   [:div.container
     [pagination]
     (when-let [qty (:nb-hits @db)]
       [:p.total-found (str "We found " qty " jobs matching your criteria")])
     [hits (:hits @db)]]])

;; start is called by init and after code reloading finishes
(defn ^:dev/after-load start []
  (rdom/render [app]
               (.getElementById js/document "app")))

(defn init []
  ;; init is called ONCE when the page loads
  ;; this is called in the index.html and must be exported
  ;; so it is available even in :advanced release builds
  #_(js/console.log "init")
  (start))

;; this is called before any code is reloaded
(defn ^:dev/before-load stop []
  #_(js/console.log "stop"))
