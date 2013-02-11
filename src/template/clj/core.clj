(ns template.clj.core
  (:use [clojure.string]))

(defn attr [a-map]
  ^{:doc "renders an attribute"}
  (clojure.string/join " "
    (map
      (fn [[k v]] (str (clojure.string/replace k ":" "") "='" v "'")) (into (sorted-map) a-map))))

(defn as-tag-list [tags]
  ^{:doc "renders a list of tags"}
  (clojure.string/join "" (map str tags)))

(defn tag
  ^{:doc "renders a tag with or without attributes"}
  ([tag-name value attrs]
   (str "<" tag-name " " (attr attrs) ">" value "</" tag-name ">"))
  ([tag-name value]
   (str "<" tag-name ">" value "</" tag-name ">")))

;(defn document [elements]
  ;^{:doc "renders a xml document using shortcuts"}
  ;(as-tag-list (map #(vector (str (first %)) (rest %)) elements)))

