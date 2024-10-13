(ns com.test.app
  (:require [com.biffweb :as biff :refer [q]]
            [com.test.middleware :as mid]
            [com.test.ui :as ui]
            [com.test.settings :as settings]
            [rum.core :as rum]
            [xtdb.api :as xt]
            [ring.adapter.jetty9 :as jetty]
            [cheshire.core :as cheshire]))


;; (defn bhanu [ctx]
;;   (ui/page ctx [:div
;;                 {:class "p-4 text-center rounded-lg hover:bg-gray-900 hover:text-white"}
;;                 [:form
;;                  [:div {:class "py-5"} "first name"]
;;                  [:input]]
;;                 "Hello world"]))

(defn submit [ctx] 
  {:status 200
   :headers {"content-type" "text/plain"}
   :body "HI"})
(defn bhanu [ctx]
  (ui/page ctx
           [:div
            {:class "p-4 text-center rounded-lg"}
            (biff/form
             {:action "/submit_form" :method "POST"}
                               ;; First Name
             [:div
              [:label {:for " first-name " :class " block font-medium "} " First Name "]
              [:input {:type " text " :id " first-name " :name " first-name "
                       :class " w-full p-2 border rounded-lg " :placeholder " Enter First Name "}]]

                               ;; Last Name
             [:div
              [:label {:for " last-name " :class " block font-medium "} " Last Name "]
              [:input {:type " text " :id " last-name " :name " last-name "
                       :class " w-full p-2 border rounded-lg " :placeholder " Enter Last Name "}]]

                               ;; Email
             [:div
              [:label {:for " email " :class " block font-medium "} " Email "]
              [:input {:type " email " :id " email " :name " email "
                       :class " w-full p-2 border rounded-lg " :placeholder " Enter Email "}]]

                               ;; Phone Number
             [:div
              [:label {:for " phone " :class " block font-medium "} " Phone Number "]
              [:input {:type " tel " :id " phone " :name " phone "
                       :class " w-full p-2 border rounded-lg " :placeholder " Enter Phone Number "}]]

                               ;; Submit button
             [:div
              [:button {:type " submit "
                        :class " bg-blue-500 text-white px-4 py-2 rounded-lg hover:bg-blue-700 "} " Submit "]])]))


(def module
  {:routes [["/bhanu" {:get bhanu}] ["/submit_form" {:post submit}]]})


