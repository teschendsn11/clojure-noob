(ns clojure-noob.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "I'm a little Teapot!"))

(defn runPoll
  "create a simple polling function"
  [count]
  (if (> count 50)
    (do (println count)(println "done"))
    (do (println count) (runPoll (inc count)))
  ))

