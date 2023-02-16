(ns conversor.formatador)

(defn formatar [cotacao de para]
  (str "1 " de " equivale a " cotacao " em " para))

(defn formatar-address [args]
  (str (get args "logradouro") ", " (get args "bairro") " - " (get args "localidade")))
