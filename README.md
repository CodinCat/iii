目前採用的方式為先將答案寫死在 docker image 中，尚未連結資料庫，將使用者在網頁上的程式碼儲存後再掛載到 docker 中，在 docker 進行編譯，再透過已經寫好並放在 docker 中的比對程式將執行結果與答案比對。

##server.js
啟動node.js伺服器 （預設為8080 port）
##rundocker.sh
將存下來的 java 檔掛載到 docker 並在 docker 中啟動 interactive bash
##@Docker/
目前在這個docker image中用到的檔案
###ans 
要比對的答案（純文字檔）
###Compare.java (Compare.class)
進行比對的程式
###run.sh
在docker中執行比對動作整個過程的指令檔。
第一行先讀取掉多餘的字元，之後將掛載進來的java檔複製到data資料夾（掛載進來的檔案不能直接使用），然後編譯並執行。
接著會以Linux的script指令紀錄輸入輸出，並透過col指令移除多餘字元，最後執行比對程式來比對答案。
##javahome/
存放使用者的程式碼的java檔，透過tty所產生的id來當作唯一路徑
##static/
網頁前端檔案


