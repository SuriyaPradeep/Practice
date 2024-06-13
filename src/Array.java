/*
In Java, an array is a data structure that allows you to store multiple values of the same type in a single variable.
Each value is accessed using an index, which represents its position in the array. Arrays in Java are fixed in size,
meaning once you define the size of an array, it cannot be changed.  The elements of an array are stored in contiguous memory locations.


 */
public class Array {
    private int size;
    private int[] nums;

    public Array() {
        this.size = 0;
        this.nums = new int[1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int search(int target) {
        if (isEmpty()) {
            return -1;
        }
        for (int i = 0; i < size; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public void resize(int newSize) {
        int[] newNums = new int[newSize];
        System.arraycopy(nums, 0, newNums, 0, size);
        nums = newNums;
    }

    public void insert(int num) {
        if (size == nums.length) {
            resize(size * 2);
        }
        nums[size++] = num;
    }

    public void delete(int target) {
        int index = search(target);
        if (index != -1) {
            for (int i = index; i < size - 1; i++) {
                nums[i] = nums[i + 1];
            }
            nums[--size] = 0;
            if (size > 0 && size == nums.length / 4) {
                resize(nums.length / 2);
            }
        }
    }

    public void traverse() {
        System.out.print("[ ");
        for (int i = 0; i < size; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.print("]");
        System.out.println();
    }

    public static void main(String[] args) {
        Array array = new Array();
        System.out.println(array.search(5));
        array.insert(1);
        array.insert(2);
        array.insert(3);
        array.insert(4);
        array.insert(5);
        array.traverse();
        System.out.println(array.nums.length);
        array.delete(3);
        array.traverse();
        array.delete(2);
        array.delete(1);
        array.delete(1);
        System.out.println(array.nums.length);
        array.traverse();
    }
}
