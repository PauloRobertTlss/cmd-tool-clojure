(ns conversor.core
  (:require [conversor.cambista :refer [obter-cotacao]]
            [conversor.post-code :refer [obter-address]]))

(def cmdAllowed {
            "convert" obter-cotacao
            "cep" obter-address
            })

(defn -main
  [& args]
  (let [tool (first args)]
     (if (contains? cmdAllowed tool)
        ((get cmdAllowed tool) (rest args))
        (println "Tool not found. =/")
    )))
