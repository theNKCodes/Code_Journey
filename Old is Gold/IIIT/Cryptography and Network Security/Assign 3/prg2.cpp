#include <iostream>
#include <gmpxx.h>
#include <cstdlib>
#include <ctime>
#include <string>
#include <unordered_map>

using namespace std;

void generateLargePrime(int keySize, mpz_class& pr) {
    gmp_randclass rand_gen(gmp_randinit_default);
    rand_gen.seed(time(NULL));

    do {
        pr = rand_gen.get_z_bits(keySize); 
    } while (!mpz_probab_prime_p(pr.get_mpz_t(), 25)); 
}

void generateElGamalKeys(int keySize, mpz_class& pr, mpz_class& root, mpz_class& priv_key, mpz_class& pub_key) {
    generateLargePrime(keySize, pr);

    gmp_randclass rand_gen(gmp_randinit_default);
    rand_gen.seed(time(NULL));

    mpz_class phi = pr - 1;

    do {
        root = rand_gen.get_z_range(pr - 1) + 1; 
    } while (mpz_gcd_ui(priv_key.get_mpz_t(), phi.get_mpz_t(), mpz_get_ui(root.get_mpz_t())) != 1); 

    priv_key = rand_gen.get_z_range(pr - 2) + 1; 

    mpz_powm(pub_key.get_mpz_t(), root.get_mpz_t(), priv_key.get_mpz_t(), pr.get_mpz_t()); 
}

void encryptElGamal(const mpz_class& txt, const mpz_class& pr, const mpz_class& root, const mpz_class& pub_key, mpz_class& c1, mpz_class& c2) {
    gmp_randclass rand_gen(gmp_randinit_default);
    rand_gen.seed(time(NULL));

    mpz_class k;
    mpz_class phi = pr - 1;

    do {
        k = rand_gen.get_z_range(pr - 1) + 1; 
    } while (mpz_gcd_ui(k.get_mpz_t(), phi.get_mpz_t(), 1) != 1); 

    mpz_powm(c1.get_mpz_t(), root.get_mpz_t(), k.get_mpz_t(), pr.get_mpz_t()); 

    mpz_class temp;
    mpz_powm(temp.get_mpz_t(), pub_key.get_mpz_t(), k.get_mpz_t(), pr.get_mpz_t());
    mpz_mul(c2.get_mpz_t(), txt.get_mpz_t(), temp.get_mpz_t());
    mpz_mod(c2.get_mpz_t(), c2.get_mpz_t(), pr.get_mpz_t()); 
}

int main(int argc, char* argv[]) {
    if (argc != 2) {
        cout << "Usage: " << argv[0] << " <plaintext>" << endl;
        return 1;
    }

std::unordered_map<char, int> chToNum = {
        {'0', 0}, {'1', 1}, {'2', 2}, {'3', 3}, {'4', 4}, {'5', 5}, {'6', 6}, {'7', 7}, {'8', 8}, {'9', 9},
        {' ', 10}, {'a', 11}, {'b', 12}, {'c', 13}, {'d', 14}, {'e', 15}, {'f', 16}, {'g', 17}, {'h', 18},
        {'i', 19}, {'j', 20}, {'k', 21}, {'l', 22}, {'m', 23}, {'n', 24}, {'o', 25}, {'p', 26}, {'q', 27},
        {'r', 28}, {'s', 29}, {'t', 30}, {'u', 31}, {'v', 32}, {'w', 33}, {'x', 34}, {'y', 35}, {'z', 36}
    };



    mpz_class prime, root, priv_key, pub_key, c1, c2;

    int keySize = 512; 

    generateElGamalKeys(keySize, prime, root, priv_key, pub_key);

    string txtStr = argv[1];
    mpz_class txt = 0;
    for (char c : txtStr) {
        txt *= 100; 
        txt += chToNum[c]; 
    }

    encryptElGamal(txt, prime, root, pub_key, c1, c2);

    cout << c1 << ", " << c2 << endl;

    return 0;
}
