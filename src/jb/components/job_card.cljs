(ns jb.components.job-card)

(def outer-url "https://functional.works-hub.com/jobs/")

(defn job-tags [tags]
  [:ul.job__tags
   (for [t tags]
     ^{:key (:objectID t)}
     [:li.job__tag (:label t)])])

(defn job-card [job]
  (let [job-url (str outer-url (:slug job))]
    [:div.job
     [:a.job__top {:href job-url}
      [:div.job__thumb [:img {:src (:logo job)}]]
      [:div.job__position
       [:div.job__title (:title job)]
       [:div.job__company (:company-country job)]]]
     [job-tags (:tags job)]
     [:p.job__tagline (:tagline job)]
     [:p.job__info
      [:span.job__remuneration (:remuneration job)]
      [:span.job__time (:role-type job)]
      [:span.job__modified (:last-modified-human job)]
      [:span.job__company-size (:company-size job)]]
     [:ul.job__perks
      (when (:remote job) [:li.job__perk "Remote"])
      (when (:sponsorship-offered job) [:li.job__perk "Sponsored"])]
     [:div.job__actions
      [:a.btn.btn_outline {:href job-url} "More Info"]
      [:a.btn.btn_primary {:href job-url} "Apply"]]]))

