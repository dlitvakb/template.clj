(ns template.clj.test.core
  (:use [template.clj.core])
  (:use [clojure.test]))

(testing "Template Engine"
  (deftest render-attribute
    (is (= "class='hola'" (attr {:class "hola"})))
    (is (= "class='hola' href='#'" (attr
                                   {:class "hola"
                                    :href "#"}))))

  (deftest render-tag-list
    (is (= "<p></p>" (as-tag-list (list (tag "p" "")))))
    (is (= "<div></div><p></p>" (as-tag-list (list (tag "div" "") (tag "p" ""))))))

  (deftest render-tag
    (is (= "<p>text</p>" (tag "p" "text")))
    (is (= "<p class='hola'>text</p>" (tag "p" "text" {:class "hola"})))))

;(testing "Shortcuts"
  ;(deftest render-tag-with-shortcut ; currently failing
    ;(is (= "<p>text<p>" (document ('p "text"))))))
