#include <stdio.h>
#include <string.h>

#define MAX_CATEGORIES 100
#define MAX_NAME_LEN 50

typedef struct {
    char name[MAX_NAME_LEN];
    char status[10];
} Category;

Category categories[MAX_CATEGORIES];
int categoryCount = 0;

void addCategory() {
    if (categoryCount >= MAX_CATEGORIES) {
        printf("Tidak bisa menambah kategori lagi. Batas tercapai.\n");
        return;
    }
    
    Category newCategory;
    
    printf("Masukkan nama kategori: ");
    scanf(" %[^\n]", newCategory.name);
    strcpy(newCategory.status, "Aktif");
    
    categories[categoryCount] = newCategory;
    categoryCount++;
    
    printf("Kategori berhasil ditambahkan.\n");
}

void editCategory() {
    if (categoryCount == 0) {
        printf("Belum ada kategori yang tersedia untuk diubah.\n");
        return;
    }

    // Minta pengguna untuk memasukkan nama kategori yang akan diubah
    char name[MAX_NAME_LEN];
    printf("Masukkan nama kategori yang akan diubah: ");
    scanf(" %[^\n]", name);

    int found = 0;
    for (int i = 0; i < categoryCount; i++) {
        if (strcmp(categories[i].name, name) == 0) {  // Cari kategori berdasarkan nama
            printf("Masukkan nama kategori baru: ");
            scanf(" %[^\n]", categories[i].name);  // Mengubah nama kategori
            printf("Kategori berhasil diubah.\n");
            found = 1;
            break;
        }
    }

    if (!found) {
        printf("Kategori dengan nama '%s' tidak ditemukan.\n", name);
    }
}

void deleteCategory() {
    if (categoryCount == 0) {
        printf("Belum ada kategori yang tersedia untuk dihapus.\n");
        return;
    }

    // Minta pengguna untuk memasukkan nama kategori yang akan dihapus
    char name[MAX_NAME_LEN];
    printf("Masukkan nama kategori yang akan dihapus: ");
    scanf(" %[^\n]", name);

    int found = 0;
    for (int i = 0; i < categoryCount; i++) {
        if (strcmp(categories[i].name, name) == 0) {  // Cari kategori berdasarkan nama
            // Geser semua kategori setelah yang dihapus ke posisi sebelumnya
            for (int j = i; j < categoryCount - 1; j++) {
                categories[j] = categories[j + 1];
            }
            categoryCount--;  // Kurangi jumlah kategori
            printf("Kategori berhasil dihapus.\n");
            found = 1;
            break;
        }
    }

    if (!found) {
        printf("Kategori dengan nama '%s' tidak ditemukan.\n", name);
    }
}

void searchCategory() {
    char searchName[MAX_NAME_LEN];
    printf("Masukkan nama kategori yang dicari: ");
    scanf(" %[^\n]", searchName);

    int found = 0;
    printf("Hasil pencarian:\n");
    for (int i = 0; i < categoryCount; i++) {
        if (strcmp(categories[i].name, searchName) == 0) {  
            printf("Nama: %s, Status: %s\n", categories[i].name, categories[i].status);
            found = 1;  
        }
    }

    if (!found) {
        printf("Kategori dengan nama '%s' tidak ditemukan.\n", searchName);  
    }
}

void displayCategories() {
    if (categoryCount == 0) {
        printf("Tidak ada kategori yang tersedia.\n");
        return;
    }

    // Header tabel
    printf("%-20s\t%-10s\n", "Nama Kategori", "Status");

    // Menampilkan setiap kategori dengan format kolom yang rapi
    for (int i = 0; i < categoryCount; i++) {
        printf("%-20s\t%-10s\n", categories[i].name, categories[i].status);
    }
}

int main() {
    int choice;
    
    do {
        printf("\nFitur Kategori\n");
        printf("1. Tambah Kategori\n");
        printf("2. Ubah Kategori\n");
        printf("3. Hapus Kategori\n");
        printf("4. Cari Kategori\n");
        printf("5. Lihat Semua Kategori\n");
        printf("0. Keluar\n");
        printf("Pilih menu: ");
        scanf("%d", &choice);
        
        switch (choice) {
            case 1:
                addCategory();
                break;
            case 2:
                editCategory();
                break;
            case 3:
                deleteCategory();
                break;
            case 4:
                searchCategory();
                break;
            case 5:
                displayCategories();
                break;
            case 0:
                printf("Keluar dari program.\n");
                break;
            default:
                printf("Pilihan tidak valid.\n");
        }
    } while (choice != 0);
    
    return 0;
}
