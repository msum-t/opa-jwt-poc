/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package jwt.opa.poc.dto;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class Person extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 8135828418627011249L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Person\",\"namespace\":\"jwt.opa.poc.dto\",\"fields\":[{\"name\":\"id\",\"type\":\"int\"},{\"name\":\"name1\",\"type\":\"string\"},{\"name\":\"email\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Person> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Person> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Person> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Person> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Person> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Person to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Person from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Person instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Person fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private int id;
  private java.lang.CharSequence name1;
  private java.lang.CharSequence email;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Person() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param name1 The new value for name1
   * @param email The new value for email
   */
  public Person(java.lang.Integer id, java.lang.CharSequence name1, java.lang.CharSequence email) {
    this.id = id;
    this.name1 = name1;
    this.email = email;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return name1;
    case 2: return email;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.Integer)value$; break;
    case 1: name1 = (java.lang.CharSequence)value$; break;
    case 2: email = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public int getId() {
    return id;
  }


  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(int value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'name1' field.
   * @return The value of the 'name1' field.
   */
  public java.lang.CharSequence getName1() {
    return name1;
  }


  /**
   * Sets the value of the 'name1' field.
   * @param value the value to set.
   */
  public void setName1(java.lang.CharSequence value) {
    this.name1 = value;
  }

  /**
   * Gets the value of the 'email' field.
   * @return The value of the 'email' field.
   */
  public java.lang.CharSequence getEmail() {
    return email;
  }


  /**
   * Sets the value of the 'email' field.
   * @param value the value to set.
   */
  public void setEmail(java.lang.CharSequence value) {
    this.email = value;
  }

  /**
   * Creates a new Person RecordBuilder.
   * @return A new Person RecordBuilder
   */
  public static jwt.opa.poc.dto.Person.Builder newBuilder() {
    return new jwt.opa.poc.dto.Person.Builder();
  }

  /**
   * Creates a new Person RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Person RecordBuilder
   */
  public static jwt.opa.poc.dto.Person.Builder newBuilder(jwt.opa.poc.dto.Person.Builder other) {
    if (other == null) {
      return new jwt.opa.poc.dto.Person.Builder();
    } else {
      return new jwt.opa.poc.dto.Person.Builder(other);
    }
  }

  /**
   * Creates a new Person RecordBuilder by copying an existing Person instance.
   * @param other The existing instance to copy.
   * @return A new Person RecordBuilder
   */
  public static jwt.opa.poc.dto.Person.Builder newBuilder(jwt.opa.poc.dto.Person other) {
    if (other == null) {
      return new jwt.opa.poc.dto.Person.Builder();
    } else {
      return new jwt.opa.poc.dto.Person.Builder(other);
    }
  }

  /**
   * RecordBuilder for Person instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Person>
    implements org.apache.avro.data.RecordBuilder<Person> {

    private int id;
    private java.lang.CharSequence name1;
    private java.lang.CharSequence email;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(jwt.opa.poc.dto.Person.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.name1)) {
        this.name1 = data().deepCopy(fields()[1].schema(), other.name1);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.email)) {
        this.email = data().deepCopy(fields()[2].schema(), other.email);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
    }

    /**
     * Creates a Builder by copying an existing Person instance
     * @param other The existing instance to copy.
     */
    private Builder(jwt.opa.poc.dto.Person other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.name1)) {
        this.name1 = data().deepCopy(fields()[1].schema(), other.name1);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.email)) {
        this.email = data().deepCopy(fields()[2].schema(), other.email);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public int getId() {
      return id;
    }


    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public jwt.opa.poc.dto.Person.Builder setId(int value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public jwt.opa.poc.dto.Person.Builder clearId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'name1' field.
      * @return The value.
      */
    public java.lang.CharSequence getName1() {
      return name1;
    }


    /**
      * Sets the value of the 'name1' field.
      * @param value The value of 'name1'.
      * @return This builder.
      */
    public jwt.opa.poc.dto.Person.Builder setName1(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.name1 = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'name1' field has been set.
      * @return True if the 'name1' field has been set, false otherwise.
      */
    public boolean hasName1() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'name1' field.
      * @return This builder.
      */
    public jwt.opa.poc.dto.Person.Builder clearName1() {
      name1 = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'email' field.
      * @return The value.
      */
    public java.lang.CharSequence getEmail() {
      return email;
    }


    /**
      * Sets the value of the 'email' field.
      * @param value The value of 'email'.
      * @return This builder.
      */
    public jwt.opa.poc.dto.Person.Builder setEmail(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.email = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'email' field has been set.
      * @return True if the 'email' field has been set, false otherwise.
      */
    public boolean hasEmail() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'email' field.
      * @return This builder.
      */
    public jwt.opa.poc.dto.Person.Builder clearEmail() {
      email = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Person build() {
      try {
        Person record = new Person();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.Integer) defaultValue(fields()[0]);
        record.name1 = fieldSetFlags()[1] ? this.name1 : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.email = fieldSetFlags()[2] ? this.email : (java.lang.CharSequence) defaultValue(fields()[2]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Person>
    WRITER$ = (org.apache.avro.io.DatumWriter<Person>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Person>
    READER$ = (org.apache.avro.io.DatumReader<Person>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeInt(this.id);

    out.writeString(this.name1);

    out.writeString(this.email);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.id = in.readInt();

      this.name1 = in.readString(this.name1 instanceof Utf8 ? (Utf8)this.name1 : null);

      this.email = in.readString(this.email instanceof Utf8 ? (Utf8)this.email : null);

    } else {
      for (int i = 0; i < 3; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.id = in.readInt();
          break;

        case 1:
          this.name1 = in.readString(this.name1 instanceof Utf8 ? (Utf8)this.name1 : null);
          break;

        case 2:
          this.email = in.readString(this.email instanceof Utf8 ? (Utf8)this.email : null);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










