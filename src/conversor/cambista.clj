(ns conversor.cambista
  (:require [clj-http.client :as http-client]
            [cheshire.core :refer [parse-string]]
            [conversor.interpretador-de-opcoes :refer [interpretar-opcoes]]
            [conversor.formatador :refer [formatar]]
            ))

(def chave (System/getenv "CHAVE_API"))

(def api-url-convert "http://localhost:8080/api/convert")

(defn- parametrizar-moedas [de para]
  (str de "_" para))

;╰─❯ lein run convert -d USD -p BRL
(defn obter-cotacao [args]
  (let [{:keys [de para]} (interpretar-opcoes args)
        moedas (parametrizar-moedas de para)]
    (-> (:body (http-client/get api-url-convert
                     {:query-params { "q" moedas
                                      "apiKey" chave}}))
        (parse-string)
        (get-in ["results" moedas "val"])
        (formatar de para)
        (prn)
        )))


