export interface Person {
  id: string;
  firstName: string;
  lastName: string;
  fatherName: string;
  dateOfBirth: string;
  nationalId: string;
  occupation: string;
}

export interface Address {
  id: string;
  type: 'Home' | 'Work' | 'Other';
  street: string;
  city: string;
  state: string;
  zipCode: string;
  country: string;
}

export interface Contact {
  id: string;
  type: 'Phone' | 'Email' | 'Fax' | 'Other';
  value: string;
  isPrimary: boolean;
}