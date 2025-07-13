import React from 'react';
import { Person } from '../types';

interface PersonInfoProps {
  person: Person;
}

const PersonInfo: React.FC<PersonInfoProps> = ({ person }) => {
  return (
    <div className="person-info-section">
      <h1>Person Information</h1>
      <div className="person-info-grid">
        <div className="info-item">
          <label>First Name:</label>
          <span>{person.firstName}</span>
        </div>
        <div className="info-item">
          <label>Last Name:</label>
          <span>{person.lastName}</span>
        </div>
        <div className="info-item">
          <label>Father's Name:</label>
          <span>{person.fatherName}</span>
        </div>
        <div className="info-item">
          <label>Date of Birth:</label>
          <span>{person.dateOfBirth}</span>
        </div>
        <div className="info-item">
          <label>National ID:</label>
          <span>{person.nationalId}</span>
        </div>
        <div className="info-item">
          <label>Occupation:</label>
          <span>{person.occupation}</span>
        </div>
      </div>
    </div>
  );
};

export default PersonInfo;