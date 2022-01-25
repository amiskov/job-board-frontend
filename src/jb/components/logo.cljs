(ns jb.components.logo)

(defn logo []
  [:div.logo
   [:img.logo__img {:src "/img/logo.svg"}]
   [:div.logo__text
    [:div.logo__text-top "Functional"]
    [:div.logo__text-bottom "Works"]]])

