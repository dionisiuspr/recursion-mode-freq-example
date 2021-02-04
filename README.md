# recursion-mode-freq-example
## Mencari modus dan frekuensinya
Ada n nilai yang sudah terurut, disimpan di array a(1..n), dimana modus adalah nilai yang paling sering muncul.

## Ide rekursif
Mencari modus dari a(1..n) dan mencari modus dari a(1..n-1)
Pada a(1..n-1) nilai m muncul f kali
- Jika a(n-1)<> a(n) => a(n) tidak dapat menjadi modus baru dan m-f tidak perlu diubah
- Jika a(n-1)=a(n), ada 3 kondisi :
  a) Tidak ada perubahan pada m dan f
  b) m tidak berubah, f ditambah 1
  c) a(n) merupakan modus baru dan f bertambah 1
  
Jika a(n)=a(n-f), maka ada n-(n-f)+1=f+1 elemen yg = a(n)

Sehingga a(n) adalah:
1) sebuah modus baru dengan frekuensi f+1 atau  
2) sebuah modus yang sama dengan m dan f bertambah 1

Untuk kedua kasus tsb, m=a(n) tetap berlaku
