(ns main
  (:require [reacl-c.core :as c :include-macros true]
            [reacl-c.main :as main]
            [reacl-c.dom :as dom]
            [reacl-c-basics.forms.core :as forms]
            [reacl-c-basics.forms.types :as types]))







(def style-1 {:style {:margin "50px"}})
(def style-2 {:style {:margin-bottom "50px"}})

(def initial-state {:name "" :age 0})


(c/defn-item labelled-input
  [label type]
  (dom/div
   (dom/div label)
   (forms/input {:type type})))


(defn root []
  (c/fragment
   (dom/div
    style-1

    (dom/h1 style-2
            "Gib bitte Deinen Namen und Dein Alter ein")

    (c/focus :name (labelled-input "Name" "string"))
    (c/focus :age (labelled-input "Alter" types/integer))
    
    (dom/br)
    (dom/br)

    (dom/button "Submit"))))












(defn ^{:export true :dev/after-load true}
  init
  []
  (main/run (.getElementById js/document "root")
    (root)
    {:initial-state initial-state}))





































;; weiteres Feld
;; (c/focus :age (labelled-input "Alter" types/integer))



;; SUBMIT FN
;; {:onclick (fn [ev] (js/alert "Submitted!")
;;                 (c/return :state initial-state))}
