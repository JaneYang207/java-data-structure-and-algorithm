package data_structure;

public class CustomStringBuilder
{
	char[] value;
	int count;

	public CustomStringBuilder() {
		this.value = new char[16];
		this.count = 0;
	}

	public CustomStringBuilder(int capacity) {
		this.value = new char[capacity];
		this.count = 0;
	}

  /**
   * @return returns the number of characters we have already
   */
	public int length() {
	  return count;
  }

  /**
   *
   * @return returns the capacity (how many characters can we store)
   */
  public int capacity() {
	  return value.length;
  }

	public CustomStringBuilder append(char ch) {
		ensureCapacity(1+count);
		value[count] = ch;
		count++;
		return this;
	}

	public CustomStringBuilder append(char[] chs) {
		int len = chs.length;
		ensureCapacity(len + count);
		System.arraycopy(chs, 0, value, count, len);
		count += len;
		return this;
	}

	public CustomStringBuilder append(String str) {
    int len = str.length();

    // ensure capacity, expand value[] if necessary
		ensureCapacity(len + count);

		// copy characters over
		System.arraycopy(str.toCharArray(), 0, value, count, len);

		// increase count
		count += len;

		return this;
	}

  /**
   * Ensure the capacity is at least equal to the specified minimum
   * Whether to expand: Only if the minimumCapacity exceeds the old capacity
   * How much to expand: if the minimumCapacity is larger than 2*oldCapacity + 2, new capacity should be minimumCapacity;
   *                     else, the new capacity should be 2*oldCapacity + 2
   * @param minimumCapacity
   */
	private void ensureCapacity(int minimumCapacity) {

	  // only expand capacity if exceeds the old capacity
		if(value.length < minimumCapacity) {
			expandCapacity(minimumCapacity);
		}
	}

	private void expandCapacity(int minimumCapacity) {
		int newCapacity = Math.max(2 * value.length + 2, minimumCapacity);
    char[] destination = new char[newCapacity];
    System.arraycopy(value, 0, destination, 0, value.length);
    value = destination;
	}

  public void display() {
    for(int i=0; i<count; i++) {
      System.out.print(value[i]+" ");
    }
  }


	public static void main(String[] args) {
		CustomStringBuilder myStringBuilder = new CustomStringBuilder();

		myStringBuilder.append('a');

		String str = "bcd";
		myStringBuilder.append(str.toCharArray());

		myStringBuilder.append("efghi");

		myStringBuilder.display();
	}
}
