目前採用的方式為先將答案寫死在 node 後端程式中，尚未連結資料庫，將使用者在網頁上的程式碼儲存並將答案也存進去，再掛載到 docker 中並進行編譯，再透過已經寫好在 docker 中的比對程式將執行結果與答案比對。

執行 docker 後，預設路徑為 data/ ，從系統中掛載的檔案存放在 mounted/ 中，由於掛載的檔案無法直接使用，因此將 mounted/ 中的檔案（Main.java 及 ans）複製到 data/ 中，再進行比對的動作。


##server.js
啟動 node.js 伺服器 （預設為 8080 port）

##rundocker.sh
將存下來的 java 檔掛載到 docker 並在 docker 中啟動 interactive bash

##@Docker/
目前在這個 docker image 中用到的檔案
###ans 
要比對的答案（純文字檔）
###Compare.java (Compare.class)
進行答案比對的程式
###run.sh
在 docker 中執行比對動作整個過程的指令檔。  
第一行先讀取掉多餘的字元，之後將掛載進來的 java 檔複製到 data 資料夾（掛載進來的檔案不能直接使用），然後編譯並執行。  
接著會以 Linux 的 script 指令紀錄輸入輸出，並透過 col 指令移除多餘字元，最後執行比對程式來比對答案。

##javahome/
存放使用者的程式碼的 java 檔，透過 tty 所產生的 id 來當作唯一路徑

##static/
網頁前端檔案


