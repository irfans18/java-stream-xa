## Table of Contents

- [ArraySum](#arraysum)
- [MergeSort](#mergesort)
- [Pyramid](#pyramid)
- [SearchText](#searchtext)
- [SortHashMap](#sorthashmap)

## ArraySum

```java
public void reduce (Integer[] numbers) {
    // 1. Sum array of int values using for loop
    int sum = 0;
    for (Integer number : numbers) {
        sum += number;
    }
    System.out.println("Sum using for loop: " + sum);

    // 2. Sum array of int values using stream reduce
    Integer reduce = Arrays.stream(numbers).reduce(0, Integer::sum);
    System.out.println("Sum using stream reduce: " + reduce);
}
```

Metode `reduce` ini digunakan untuk menghitung jumlah elemen dalam array `numbers`. Penjelasan singkat dari kode tersebut adalah sebagai berikut:

1. **Perulangan for**: Di sini, setiap elemen dalam array `numbers` ditambahkan ke variabel `sum` menggunakan perulangan for. Pada akhirnya, `sum` akan berisi jumlah dari semua elemen dalam array.

2. **Stream reduce**: Dalam pendekatan ini, kita menggunakan stream dari array `numbers`. Fungsi `reduce` dari stream digunakan untuk menggabungkan semua elemen dengan operasi reduksi, dalam hal ini penambahan. Angka awal untuk reduksi ditetapkan sebagai 0, dan operasi penambahan (`Integer::sum`) diterapkan pada setiap elemen untuk menghitung jumlah total.

Dengan menggunakan kedua metode ini, kita dapat mencapai hasil yang sama, namun penggunaan stream `reduce` memanfaatkan fitur stream Java yang lebih modern dan ekspresif.

## MergeSort

```java
public void mergeSort(int[] arr) {
    // If the array has more than one element
    if (arr.length > 1) {
        // Calculate the middle index of the array
        int mid = arr.length / 2;

        // Split the array into two halves
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        // Recursively sort the left half
        mergeSort(left);
        // Recursively sort the right half
        mergeSort(right);

        // Merge the sorted halves
        int leftIndex = 0, rightIndex = 0, mergedIndex = 0;
        while (leftIndex < left.length && rightIndex < right.length) {
            // Compare elements from left and right halves and merge them into arr
            if (left[leftIndex] < right[rightIndex]) {
                arr[mergedIndex++] = left[leftIndex++];
            } else {
                arr[mergedIndex++] = right[rightIndex++];
            }
        }

        // Copy any remaining elements from left half
        while (leftIndex < left.length) {
            arr[mergedIndex++] = left[leftIndex++];
        }

        // Copy any remaining elements from right half
        while (rightIndex < right.length) {
            arr[mergedIndex++] = right[rightIndex++];
        }
    }
}
```

Metode `mergeSort` ini mengimplementasikan algoritma pengurutan Merge Sort untuk mengurutkan array `arr`. Penjelasan singkat dari kode tersebut adalah sebagai berikut:

1. **Pengecekan Array**: Pertama, kode memeriksa apakah array memiliki lebih dari satu elemen. Jika tidak, maka array sudah dalam keadaan terurut.

2. **Pembagian Array**: Array dibagi menjadi dua bagian, yaitu separuh kiri dan separuh kanan.

3. **Pengurutan Rekursif**: Masing-masing bagian array diurutkan secara rekursif dengan menggunakan metode `mergeSort` itu sendiri.

4. **Penggabungan**: Setelah kedua bagian array terurut, kedua bagian tersebut digabungkan kembali dengan membandingkan elemen-elemennya. Proses penggabungan dilakukan dengan mengambil elemen terkecil dari kedua bagian array dan menyusunnya kembali ke dalam array utama `arr`.

Dengan menggunakan algoritma Merge Sort, array dapat diurutkan secara efisien dalam waktu O(n log n), di mana n adalah jumlah elemen dalam array.

## Pyramid

```java
public void printPyramid(int n, char symbol) {
    IntStream.range(0, n)
            .forEach(i -> {
                // Printing spaces
                IntStream.range(0, n - i - 1)
                        .forEach(j -> System.out.print(" "));
                // Printing symbol
                IntStream.range(0, i + 1)
                        .forEach(j -> System.out.printf("%c ", symbol));
                // Ending line after each row
                System.out.println();
            });
}
```

Metode `printPyramid` digunakan untuk mencetak piramida menggunakan karakter tertentu dengan tinggi sebanyak `n`. Penjelasan singkat dari kode tersebut adalah sebagai berikut:

1. **Perulangan untuk Baris**: Melalui perulangan `IntStream`, untuk setiap baris dari 0 hingga `n - 1`, kita lakukan hal berikut:

2. **Printing spaces**: Pada setiap baris, cetak sejumlah spasi yang sesuai untuk membuat pola piramida. Jumlah spasi yang dicetak akan berkurang seiring dengan penambahan baris.

3. **Printing symbol**: Setelah mencetak spasi, cetak karakter yang diberikan (`symbol`) sebanyak `i + 1` kali untuk membentuk pola piramida.

4. **Ending line after each row**: Setelah mencetak spasi dan karakter, akhiri baris untuk menyelesaikan baris piramida saat ini.

Dengan menggunakan metode ini, kita dapat mencetak piramida dengan tinggi `n` dan menggunakan karakter yang ditentukan secara dinamis.

## SearchText
file `sikancil.txt` terdapat pada `src/main/resource/sikancil.txt`
```java
public List<String> searchForText(String fileName, String searchString) {
    List<String> textFound = new ArrayList<>(); // Initiate List
    try (Scanner scanner = new Scanner(new File(fileName))) { // Opening File
        int lineNumber = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lineNumber++;
            if (line.toLowerCase().contains(searchString)) { // Search Text
                textFound.add(String.format("String ditemukan pada line %d: ", lineNumber) + line);
            }
        }
    } catch (FileNotFoundException e) { // Exception Handling
        System.err.println("File tidak ditemukan: " + e.getMessage());
    }
    return textFound; // Return Result
}
```

Metode `searchForText` ini digunakan untuk mencari teks tertentu dalam sebuah file dan mengembalikan daftar baris di mana teks tersebut ditemukan. Penjelasan singkat dari kode tersebut adalah sebagai berikut:

1. **Initiate List**: Sebuah objek `ArrayList` digunakan untuk menyimpan teks yang ditemukan.

2. **Opening File**: File yang ditentukan oleh `fileName` dibuka untuk dibaca dengan menggunakan `Scanner`.

3. **Search Text**: Setiap baris dari file dibaca secara berurutan. Jika baris tersebut mengandung teks yang dicari (dalam bentuk lowercase), maka informasi tentang letak baris tersebut ditambahkan ke dalam list `textFound`.

4. **Exception Handling**: Jika file tidak ditemukan, sebuah pesan kesalahan akan dicetak.

5. **Return Result**: List yang berisi informasi tentang lokasi teks yang ditemukan dikembalikan.

Dengan menggunakan metode ini, kita dapat mencari teks dalam sebuah file dan mendapatkan informasi tentang letak kemunculannya dalam bentuk daftar baris.

## SortHashMap

Berikut adalah penjelasan dari kode di atas yang akan ditambahkan ke dalam README.md di repositori GitHub:

```java
public Map<String, String> sortByValues(Map<String, String> map) {
    // #Convert the map entries to a list and sort them using a custom comparator
    List<Map.Entry<String, String>> list = map.entrySet().stream().sorted(new Comparator<Map.Entry<String, String>>() {
        @Override
        public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
            return o1.getValue().compareTo(o2.getValue());
        }
    }).toList();

    // #Reconstruct the sorted map using LinkedHashMap to preserve insertion order
    Map<String, String> sortedMap = new LinkedHashMap<>();
    for (Map.Entry<String, String> entry : list) {
        sortedMap.put(entry.getKey(), entry.getValue());
    }

    return sortedMap; // #Return sortedMap
}
```

Metode `sortByValues` ini digunakan untuk mengurutkan `Map` berdasarkan nilai-nilai (values) dari entri-entri di dalamnya. Penjelasan singkat dari kode tersebut adalah sebagai berikut:

1. **#Convert the map entries**: Pertama-tama, entri-entri dari map dikonversi menjadi sebuah list menggunakan `stream()`, kemudian diurutkan berdasarkan nilai-nilai dari entri-entri tersebut menggunakan sebuah komparator khusus. Komparator ini dibuat dalam bentuk anonymous inner class yang mengimplementasikan metode `compare` untuk membandingkan nilai-nilai dari dua entri.

2. **#Reconstruct the sorted map**: Setelah diurutkan, list tersebut digunakan untuk membangun kembali sebuah map yang sudah diurutkan. Karena map dalam Java tidak menjamin urutan penyisipan, kita menggunakan `LinkedHashMap` untuk mempertahankan urutan penyisipan yang telah diatur.

3. **#Return sortedMap**: Map yang sudah diurutkan berdasarkan nilai-nilainya dikembalikan kepada pemanggil metode.

Dengan menggunakan metode ini, kita dapat mengurutkan map berdasarkan nilai-nilainya dengan mempertahankan urutan penyisipan entri-entri tersebut.
