(ns clojure-noob.core
  (:gen-class)
  (:require [korma.db :as kdb]
            [korma.core :as kCore]
            [clojure.data.json :as json]))
(defn runPoll
  "create a simple polling function"
  [count]
  (if (> count 50)
    (do (println count)(println "done"))
    (do (println count) (runPoll (inc count)))
    ))

(defn getUserData
  "dbTest"
  []
  (kdb/defdb db (mysql {:db "clojure_test"
                  :user "clojure"
                    :password "buckydorf"}))
  
  (kCore/defentity user)
  (kCore/select user))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (def results (map #(str (:firstname %) " " (:lastname %)) (getUserData)))
  (println (first results)))
