(ns conversor.post-code
  (:require [clj-http.client :as http-client]
            [cheshire.core :refer [parse-string]]
            [conversor.formatador :refer [formatar-address]]))

(defn api-url [code]
  (str "https://viacep.com.br/ws/" code "/json/"))
; lein run cep 06280090
(defn obter-address [args]
  (let [code (first args)]
    (->
      (:body (http-client/get (api-url code)))
        (parse-string)
        (formatar-address)
        (pr)
        )))