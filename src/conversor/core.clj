(ns conversor.core
  (:require [conversor.cambista :refer [obter-cotacao]]
            [conversor.post-code :refer [obter-address]]))

(def aliasTools {
            "convert" obter-cotacao
            "cep" obter-address
            })

(defn -main
  [& args]
  (let [tool (first args)]
     (if (contains? aliasTools tool)
        ((get aliasTools tool) (rest args))
        (println "Tool not found. =/")
    )))
